name = "Bob"
greeting = f"Hello,{name}"
print(greeting)


greeting = "Hello,{}"
with_name = greeting.format(name)
print(with_name)

longer_phrase = "hello {} , today is {}."
formatted = longer_phrase.format("rolf","monday")
print(formatted)

