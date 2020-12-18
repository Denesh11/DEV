numbers = [2,8,20]
doubled = [num*3 for num in numbers]
print(doubled)
friends = ["denesh", "drama","deep","head","starc"]
starts_d = [friend for friend in friends if friend.startswith("d")]
print(starts_d)
print(friends)
print(friends is starts_d)
print("Friends: ", id(friends), "starts_d: ", id(starts_d))