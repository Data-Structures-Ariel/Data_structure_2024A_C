import time
import random

start = int(round(time.time() * 1000))

arr = [random.randint(0, 599) for _ in range(100000)]

for i in range(len(arr)):
    if arr[i] == random.randint(0, 599):
        print("V")
        break

end = int(round(time.time() * 1000))
print("Time of algo -> " + str(end - start))