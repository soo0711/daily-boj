import os
from urllib import parse

HEADER = """#
# 백준, 프로그래머스 문제 풀이 목록
"""

def main():
    content = HEADER + "\n"

    directories = []

    for root, dirs, files in os.walk("."):
        dirs.sort()
        if root == '.':
            for dir_name in ('.git', '.github'):
                try:
                    dirs.remove(dir_name)
                except ValueError:
                    pass
            continue

        category = os.path.basename(root)
        if category == 'images':
            continue

        parent_dir = os.path.basename(os.path.dirname(root))
        if parent_dir == '.':
            continue

        # 상위 폴더 섹션
        if parent_dir not in directories:
            if parent_dir in ["백준", "프로그래머스"]:
                content += f"## 📚 {parent_dir}\n\n"
            else:
                content += f"### 🚀 {parent_dir}\n"
                content += "| 문제번호 | 링크 |\n"
                content += "| ----- | ----- |\n"
            directories.append(parent_dir)

        # 파일별 링크 추가
        for file in files:
            parts = category.split("_", 2)  # ['boj', '123', '더하기']
            if len(parts) >= 3:
                problem_number = parts[1]
                problem_name = parts[2]
            else:
                problem_number = category
                problem_name = category

            display_text = f"{problem_number}. {problem_name}"
            file_path = parse.quote(os.path.join(root, file))
            content += f"|{display_text}|[링크]({file_path})|\n"

    with open("README.md", "w", encoding="utf-8") as fd:
        fd.write(content)

if __name__ == "__main__":
    main()