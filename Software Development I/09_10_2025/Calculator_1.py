value_1 = int(input ("Give me a numeber "))
value_2 = int(input ("Give a second number "))

operators = input ("Give an operator (+, -, *, / )")


if operators == "*":
    final_value =  value_1 * value_2
    print (final_value)

if operators == "+":
    final_value =  value_1 + value_2
    print (final_value)

if operators == "-":
    final_value =  value_1 - value_2
    print (final_value)

if operators == "/":
    final_value =  value_1 / value_2
    print (final_value)

else:
    print ("Enter a valid operator")








