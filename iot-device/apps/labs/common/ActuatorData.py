'''
Created on 2018年9月15日

@author: andyyuan
'''
import os
from datetime import datetime

COMMAND_OFF = 0
COMMAND_ON = 1
COMMAND_SET = 2
COMMAND_RESET = 3
STATUS_IDLE = 0
STATUS_ACTIVE = 1
ERROR_OK = 0
ERROR_COMMAND_FAILED = 1
ERROR_NON_RESPONSIBLE = -1

class ActuatorData():
    
    timeStamp = None
    name = 'Not set'
    hasError = False
    command = 0
    errCode = 0
    statusCode = 0
    stateData = None
    val = 0.0
    
    def __init__(self):
        self.updateTimeStamp()
        
    def getCommand(self):
        return self.command
    
    def getName(self):
        return self.name
    
    def getStateData(self):
        return self.stateData
    
    def getStatusCode(self):
        return self.statusCode
    
    def getErrorCode(self):
        return self.errCode
    
    def getValue(self):
        return self.val;
    
    def hasError(self):
        return self.hasError
    
    def setCommand(self, command):
        self.command = command
        
    def setName(self, name):
        self.name = name
        
    def setStateData(self, stateData):
        self.stateData = stateData
        
    def setStatusCode(self, statusCode):
        self.statusCode = statusCode
        
    def setErrorCode(self, errCode):
        self.errCode = errCode
        if (self.errCode != 0):
            self.hasError = True
        else:
            self.hasError = False
            
    def setValue(self, val):
        self.val = val
        
    def updateData(self, data):
        self.command = data.getCommand()
        self.statusCode = data.getStatusCode()
        self.errCode = data.getErrorCode()
        self.stateData = data.getStateData()
        self.val = data.getValue()
    
    def updateTimeStamp(self):
        self.timeStamp = str(datetime.now())
    def __str__(self):
        customStr = \
            str(self.name + ':' + \
            os.linesep + '\tTime: ' + self.timeStamp + \
            os.linesep + '\tCommand: ' + str(self.command) + \
            os.linesep + '\tStatus Code: ' + str(self.statusCode) + \
            os.linesep + '\tError Code: ' + str(self.errCode) + \
            os.linesep + '\tState Data: ' + str(self.stateData) + \
            os.linesep + '\tValue: ' + str(self.val))
        return customStr