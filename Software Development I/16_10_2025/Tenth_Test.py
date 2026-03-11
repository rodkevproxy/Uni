import random 

hidden_number = random.randint (1, 20) 
guess = 0 

print("Number betqeen 1 and 20 ")

for attempt_count in range (1, 6):
    print (f"Attempt {attempt_count} of 5")
    guess = int(input("Enter your guess "))

    if guess == hidden_number: 
        break
    elif guess < hidden_number: 
        print ("Too high")
    else:
        print("Too low ")

if guess == hidden_number: 
    print (f"Correct. The number is {hidden_number} and you made in attempt {attempt_count}")
else: 
    print (f"You ran out of guesses. The number was {hidden_number}")



