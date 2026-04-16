from __future__ import annotations

import os
import subprocess
from collections import Counter
from datetime import datetime, timedelta, timezone
from pathlib import Path


README_PATH = Path("README.md")
START_MARKER = "<!-- COMMIT_RANKING:START -->"
END_MARKER = "<!-- COMMIT_RANKING:END -->"
KST = timezone(timedelta(hours=9))
EXCLUDED_AUTHORS = {
    "github-actions[bot]",
    "dependabot[bot]",
}


def run_git_log(since: datetime) -> list[str]:
    result = subprocess.run(
        [
            "git",
            "log",
            "--all",
            "--no-merges",
            f"--since={since.isoformat()}",
            "--pretty=format:%an",
        ],
        check=True,
        capture_output=True,
        text=True,
    )
    return [
        name.strip()
        for name in result.stdout.splitlines()
        if name.strip() and name.strip() not in EXCLUDED_AUTHORS
    ]


def get_week_start(now: datetime) -> datetime:
    return (now - timedelta(days=now.weekday())).replace(
        hour=0,
        minute=0,
        second=0,
        microsecond=0,
    )


def format_ranking(names: list[str], updated_at: datetime) -> str:
    counter = Counter(names)

    lines = [
        "| 순위 | 이름 | 커밋 수 |",
        "| --- | --- | --- |",
    ]

    if not counter:
        lines.append("| - | 아직 집계된 커밋이 없습니다. | - |")
    else:
        for rank, (name, count) in enumerate(counter.most_common(), start=1):
            medal = {1: "🥇", 2: "🥈", 3: "🥉"}.get(rank, str(rank))
            lines.append(f"| {medal} | {name} | {count} |")

    lines.extend(
        [
            "",
            f"마지막 업데이트: {updated_at.strftime('%Y-%m-%d %H:%M')} KST",
        ]
    )
    return "\n".join(lines)


def update_readme(ranking: str) -> bool:
    readme = README_PATH.read_text(encoding="utf-8")

    if START_MARKER not in readme or END_MARKER not in readme:
        raise RuntimeError("README.md에 커밋 랭킹 마커가 없습니다.")

    before, rest = readme.split(START_MARKER, 1)
    _, after = rest.split(END_MARKER, 1)
    updated = f"{before}{START_MARKER}\n{ranking}\n{END_MARKER}{after}"

    if updated == readme:
        return False

    README_PATH.write_text(updated, encoding="utf-8")
    return True


def main() -> None:
    now = datetime.now(KST)
    week_start = get_week_start(now)
    names = run_git_log(week_start)
    ranking = format_ranking(names, now)
    changed = update_readme(ranking)

    github_output = os.environ.get("GITHUB_OUTPUT")
    if github_output:
        with open(github_output, "a", encoding="utf-8") as output:
            output.write(f"changed={str(changed).lower()}\n")


if __name__ == "__main__":
    main()
