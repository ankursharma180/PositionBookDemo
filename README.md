# PositionBookDemo
This java program is for trading transaction.

**Assumptions:**
It is assumed the data in real systems would be coming from some queue or via some event in the form of json etc.
Likewise, this program accepts trading event data as a comma seperated string **1,BUY,ACC1,SEC1,50**.
If there are more than one events, than data needs be provided using pipe operater seperating every trading event.
**1,BUY,ACC1,SEC1,50|2,SELL,ACC1,SEC1,10**

The program will break them on the basis of pipe and comma and will process the input.
Real Time Position holds the current position of a aggregated record (tradingEvent+securityIdentifer) and will display data accordingly with full event history.

Sample Output from the program:


RUN 1:

**************************************************************
*************Welcome to JP Morgan Trading Platform.***********
**************************************************************

Please provide your input: 1,BUY,ACC1,SEC1,50|2,SELL,ACC1,SEC1,10

<br /><<<<<<<<<<<<<<<<< REAL TIME POSITION >>>>>>>>>>>>>>>>>>>>>>>>>
<br />|| ACC1 || SEC1 || 40 || [id:1,BUY,ACC1,SEC1,50] [id:2,SELL,ACC1,SEC1,10] ||
<br /><<<<<<<<<<<<<<<<<<<< REAL TIME POSITION >>>>>>>>>>>>>>>>>>>>>>


<br />**********************GET SECURITIES INPUT********************
<br />Please provide your input: 3,BUY,ACC1,SEC1,12|4,CANCEL,ACC1,SEC1,0

<br /><<<<<<<<<<<<<<<<< REAL TIME POSITION >>>>>>>>>>>>>>>>>>>>>>>>>
<br />|| ACC1 || SEC1 || 40 || [id:1,BUY,ACC1,SEC1,50] [id:2,SELL,ACC1,SEC1,10] [id:3,BUY,ACC1,SEC1,12] [id:4,CANCEL,ACC1,SEC1,0] ||
<br /><<<<<<<<<<<<<<<<<<<< REAL TIME POSITION >>>>>>>>>>>>>>>>>>>>>>

**********************GET SECURITIES INPUT********************
<br />Please provide your input: 6,BUY,ACC1,SEC1,50

<br /><<<<<<<<<<<<<<<<< REAL TIME POSITION >>>>>>>>>>>>>>>>>>>>>>>>>
<br />|| ACC1 || SEC1 || 90 || [id:1,BUY,ACC1,SEC1,50] [id:2,SELL,ACC1,SEC1,10] [id:3,BUY,ACC1,SEC1,12] [id:4,CANCEL,ACC1,SEC1,0] [id:6,BUY,ACC1,SEC1,50] ||
<br /><<<<<<<<<<<<<<<<<<<< REAL TIME POSITION >>>>>>>>>>>>>>>>>>>>>>


**********************GET SECURITIES INPUT********************
<br />Please provide your input: 6,BUY,ACC2,SEC1,50|7,BUY,ACC2,SEC1,150|7,CANCEL,ACC2,SEC1,0|8,SELL,ACC2,SEC1,10

<br /><<<<<<<<<<<<<<<<< REAL TIME POSITION >>>>>>>>>>>>>>>>>>>>>>>>>
<br /> || ACC2 || SEC1 || 40 || [id:6,BUY,ACC2,SEC1,50] [id:7,BUY,ACC2,SEC1,150] [id:7,CANCEL,ACC2,SEC1,0] [id:8,SELL,ACC2,SEC1,10] ||
<br /> || ACC1 || SEC1 || 90 || [id:1,BUY,ACC1,SEC1,50] [id:2,SELL,ACC1,SEC1,10] [id:3,BUY,ACC1,SEC1,12] [id:4,CANCEL,ACC1,SEC1,0] [id:6,BUY,ACC1,SEC1,50] ||
<br /><<<<<<<<<<<<<<<<<<<< REAL TIME POSITION >>>>>>>>>>>>>>>>>>>>>>





RUN 2:

**************************************************************
*************Welcome to JP Morgan Trading Platform.***********
**************************************************************

**********************GET SECURITIES INPUT********************
<br />Please provide your input: 1,BUY,ACC1,SEC1,50|2,SELL,ACC1,SEC1,10

<br /><<<<<<<<<<<<<<<<< REAL TIME POSITION >>>>>>>>>>>>>>>>>>>>>>>>>
<br /> || ACC1 || SEC1 || 40 || [id:1,BUY,ACC1,SEC1,50] [id:2,SELL,ACC1,SEC1,10] ||
<br /><<<<<<<<<<<<<<<<<<<< REAL TIME POSITION >>>>>>>>>>>>>>>>>>>>>>

**********************GET SECURITIES INPUT********************
<br />Please provide your input: 2,CANCEL,ACC1,SEC1,0

<br /><<<<<<<<<<<<<<<<< REAL TIME POSITION >>>>>>>>>>>>>>>>>>>>>>>>>
<br /> || ACC1 || SEC1 || 50 || [id:1,BUY,ACC1,SEC1,50] [id:2,SELL,ACC1,SEC1,10] [id:2,CANCEL,ACC1,SEC1,0] ||
<br /><<<<<<<<<<<<<<<<<<<< REAL TIME POSITION >>>>>>>>>>>>>>>>>>>>>>

**********************GET SECURITIES INPUT********************
<br />Please provide your input: 3,BUY,ACC2,SEC1,100|4,BUY,ACC2,SEC1,20|5,SELL,ACC2,SEC1,10|6,CANCEL,ACC2,SEC1,0

<br /><<<<<<<<<<<<<<<<< REAL TIME POSITION >>>>>>>>>>>>>>>>>>>>>>>>>
<br /> || ACC2 || SEC1 || 120 || [id:3,BUY,ACC2,SEC1,100] [id:4,BUY,ACC2,SEC1,20] [id:5,SELL,ACC2,SEC1,10] [id:6,CANCEL,ACC2,SEC1,0] ||
<br /> || ACC1 || SEC1 || 50 || [id:1,BUY,ACC1,SEC1,50] [id:2,SELL,ACC1,SEC1,10] [id:2,CANCEL,ACC1,SEC1,0] ||
<br /><<<<<<<<<<<<<<<<<<<< REAL TIME POSITION >>>>>>>>>>>>>>>>>>>>>>

**********************GET SECURITIES INPUT********************
<br />Please provide your input: 7,BUY,ACC1,SEC1,50|8,SELL,ACC1,SEC1,15|9,CANCEL,ACC1,SEC1,0

<br /><<<<<<<<<<<<<<<<< REAL TIME POSITION >>>>>>>>>>>>>>>>>>>>>>>>>
<br /> || ACC2 || SEC1 || 120 || [id:3,BUY,ACC2,SEC1,100] [id:4,BUY,ACC2,SEC1,20] [id:5,SELL,ACC2,SEC1,10] [id:6,CANCEL,ACC2,SEC1,0] ||
<br /> || ACC1 || SEC1 || 100 || [id:1,BUY,ACC1,SEC1,50] [id:2,SELL,ACC1,SEC1,10] [id:2,CANCEL,ACC1,SEC1,0] [id:7,BUY,ACC1,SEC1,50] [id:8,SELL,ACC1,SEC1,15] [id:9,CANCEL,ACC1,SEC1,0] ||
<br /><<<<<<<<<<<<<<<<<<<< REAL TIME POSITION >>>>>>>>>>>>>>>>>>>>>>
