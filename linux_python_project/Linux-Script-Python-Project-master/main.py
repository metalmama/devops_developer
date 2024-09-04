# write a simple python script for doing a specific job, write a python script at specific times

import datetime
import json
import requests
import time

class NameDay:
    def output(self):
        response = requests.get("https://sholiday.faboul.se/dagar/v2.1/")
        # json decode response.text into data dictionary
        r = json.loads(response.text)
        #getting the names from the json response, it should be doing an error checking
        outputtext = ""
        for dagar in r["dagar"]:
            for namn in dagar["namnsdag"]:
                outputtext = outputtext + namn +"\n"
        #dump the output to a txt file
        f = open("namnsdag.txt", "w")
        f.write(outputtext)
        f.close()

    # print the name for today in the list. Runtime is once during the hour following the time set in "runTime"
    def job(self):
        date = datetime.datetime.now().strftime("%H")
        runTime = "00"
        if date != runTime:
            return
        self.output()

n = NameDay()
# automate the task of printing name so that it prints the name once a day
while True:
    n.job()
    time.sleep(3600)

