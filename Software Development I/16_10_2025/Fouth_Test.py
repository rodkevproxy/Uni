total = 0 
count = 0 

score = int(input( "Enter score, (Enter -9 to end) "))

while score != -9:

    if score == -9:
        print ("Done!")
        print (f"Count = {count}")
        print (f"total = {total}")

            
    else:
        total = total + score 
        count = count + 1 
        print ("Do it again")

    score = int(input( "Enter score, (Enter -9 to end) "))




