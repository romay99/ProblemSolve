def solution(slice, n):
    index = 1
    while (True):
        if (slice * index) / n >= 1:
            break
        index += 1
    return index