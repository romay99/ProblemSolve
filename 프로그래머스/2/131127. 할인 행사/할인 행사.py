def solution(want, number, discount):
    newArr = []
    answer = 0
    for i in range(len(want)):
        for j in range(number[i]):
            newArr.append(want[i])
    for i in range(len(discount)-sum(number)+1):
        if sorted(newArr) == sorted(discount[i:10+i]):
            answer += 1
    return answer