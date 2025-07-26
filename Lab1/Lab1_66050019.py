import re
# Lab python file นี้มีข้อ 7, 10 ครับ
def q7():
    txt = str(input("Enter the input string: "))
    x = re.search("^b*a{1}b*$", txt)

    if x:
        print("Accept")
    else:
        print("Reject")

def q10():
    txt = str(input("Enter the input string: "))
    x = re.search("^([ab]{3})*$", txt)

    if x:
        print("Accept")
    else:
        print("Reject")

q7()
q10()