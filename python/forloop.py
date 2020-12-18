friends = ["bob","greek","stev"]

for friend in range(3):
    print(f"{friend} is my friend")
for friend in friends:
    print(f"{friend} is my friend ")

grades = [43,54,67,90,87]
total = 0
amount = len(grades)

for grade in grades:
    total += grade
    print(total/amount)
print(total/amount)

total = sum(grades)
print (total/amount)