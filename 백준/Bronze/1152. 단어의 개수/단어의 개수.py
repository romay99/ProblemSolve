a = input()

cnt = 0

cnt += a.count(" ") + 1

if a[0] == " ":
    cnt -= 1
if a[-1] == " ":
    cnt -= 1

print(cnt)
