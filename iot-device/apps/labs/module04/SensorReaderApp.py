'''
Created on Oct 13, 2018

@author: andyyuan
'''

from time import sleep
from labs.module03 import TempSensorAdaptor
#from labs.module02 import SmtpClientConnector


tempSensAdaptor = TempSensorAdaptor.TempSensorAdaptor()

tempSensAdaptor.daemon = True
print('- - - - - - - - - - - - - - - - - - - - - - - - ')
print("Starting system performance app daemon thread...")
tempSensAdaptor.enableEmulator = True
tempSensAdaptor.start()

while (True):
    sleep(10)
    pass