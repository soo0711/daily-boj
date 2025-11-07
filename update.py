import os
from urllib import parse

HEADER = """# 백준, 프로그래머스 문제 풀이 목록

## 🚀 문제 목록
"""

def main():
    content = HEADER + "\n"
    content += "| 문제번호 | 링크 |\n"
    content += "| ----- | ----- |\n"

    for root, dirs, files in os.walk("src"):
        dirs.sort()
        if 'images' in dirs:
            dirs.remove('images')

        if root == "src":
            continue

        parent_dir = os.path.basename(root)

        dir_parts = parent_dir.split("_", 2)
        if len(dir_parts) >= 3:
            problem_number = dir_parts[1]
            problem_name = dir_parts[2].replace("_", " ")

            folder_path = parse.quote(root)
            content += f"| {problem_number}. {problem_name} | [링크]({folder_path}) |\n"

    with open("README.md", "w", encoding="utf-8") as fd:
        fd.write(content)

if __name__ == "__main__":
    main()