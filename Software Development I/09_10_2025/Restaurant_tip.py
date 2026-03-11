cost_of_meal = float(input("Please enter the total cost of the meal: "))
satisfaction = float(input("Please tell us how satisfied you are \n "
"1 = Totally satisfiied \n "
"2 = Satisfied \n "
"3 = Dissatisfied\n"))

if satisfaction == 1: 
    suggested_tip = 20 / cost_of_meal * 100
    print (f"Your suggested tip is {suggested_tip}£") 

if satisfaction == 2: 
    suggested_tip = 15 / cost_of_meal * 100
    print (f"Your suggested tip is {suggested_tip}£")

if satisfaction == 3: 
    suggested_tip = 10 / cost_of_meal * 100
    print (f"Your suggested tip is {suggested_tip}£")  








