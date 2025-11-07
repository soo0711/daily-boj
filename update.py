import os
from urllib import parse

HEADER = """#
# 백준, 프로그래머스 문제 풀이 목록
"""

def main():
    content = HEADER + "\n"
    directories = []

    for root, dirs, files in os.walk("src"):
        dirs.sort()
        if 'images' in dirs:
            dirs.remove('images')

        # 상위 폴더
        parent_dir = os.path.basename(root)
        if parent_dir not in directories:
            content += f"### 🚀 {parent_dir}\n"
            content += "| 문제번호 | 링크 |\n"
            content += "| ----- | ----- |\n"
            directories.append(parent_dir)

        for file in files:
            name_parts = file.split("_", 2)
            if len(name_parts) >= 3:
                problem_number = name_parts[1]
                problem_name = name_parts[2].rsplit(".", 1)[0]  # 확장자 제거
            else:
                problem_number = name_parts[0]
                problem_name = name_parts[0]

            display_text = f"{problem_number}. {problem_name}"
            file_path = parse.quote(os.path.join(root, file))
            content += f"|{display_text}|[링크]({file_path})|\n"

    with open("README.md", "w", encoding="utf-8") as fd:
        fd.write(content)

if __name__ == "__main__":
    main()