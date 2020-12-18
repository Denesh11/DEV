friend_ages = {"Rolf": 22, "Adam": 23, "Anne": 27}

friend_ages["Denim"] = 34
friend_ages["Rolf"] = 21

print(friend_ages)

friends = [
    {"name": "Rolf", "age": 22},
    {"name": "Dom", "age": 26},
    {"name": "Rock", "age": 28}
]

print(friends[1]["name"])

student_attendance = {"Rolf": 93, "Bob": 98, "Abhas": 82}

for student, attendance in student_attendance.items():
    print(student)
    print(f"{student}: {student_attendance[student]}")
    print(f"{student}: {attendance}")

student_attendance = {"Rolf": 93, "Bob": 98, "Abhas": 82}

if "Abhas" in student_attendance:
    print(f"Rolf: {student_attendance['Bob']}")
else:
    print("Bop is not a student in this class.")


student_attendance = {"Rolf": 93, "Bob": 98, "Abhas": 82}

attendance_values = student_attendance.values()
print(sum(attendance_values) / len(attendance_values))

