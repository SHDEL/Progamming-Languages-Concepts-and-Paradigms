import re

def q7():
    txt = "bbbbabbbc"
    x = re.search("^b*a{1}b*$", txt)

    if x:
        print("Accept")
    else:
        print("Reject")

def q10():
    txt = "ababbb"
    x = re.search("^([ab]{3})+$", txt)

    if x:
        print("Accept")
    else:
        print("Reject")

q10()