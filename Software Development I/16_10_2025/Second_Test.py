import random


hidden =  random.randint (1, 20) 

guess = int(input("Give me a number between 1 and 20 "))

while guess != hidden:
    print ("Sorry, that's not correct. Try again!")
    guess = int(input("Give me a number between 1 and 20 "))

print(f"Congratulations! You guessed it correctly. The number was {hidden}.")

