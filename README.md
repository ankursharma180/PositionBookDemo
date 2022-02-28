# PositionBookDemo
This java program is for trading transaction.

Sample Output from the program:


RUN 1:

**************************************************************
*************Welcome to JP Morgan Trading Platform.***********
**************************************************************

Please provide your input: 1,BUY,ACC1,SEC1,50|2,SELL,ACC1,SEC1,10

<<<<<<<<<<<<<<<<< REAL TIME POSITION >>>>>>>>>>>>>>>>>>>>>>>>>
 || ACC1 || SEC1 || 40 || [id:1,BUY,ACC1,SEC1,50] [id:2,SELL,ACC1,SEC1,10] ||
<<<<<<<<<<<<<<<<<<<< REAL TIME POSITION >>>>>>>>>>>>>>>>>>>>>>


**********************GET SECURITIES INPUT********************
Please provide your input: 3,BUY,ACC1,SEC1,12|4,CANCEL,ACC1,SEC1,0

<<<<<<<<<<<<<<<<< REAL TIME POSITION >>>>>>>>>>>>>>>>>>>>>>>>>
 || ACC1 || SEC1 || 40 || [id:1,BUY,ACC1,SEC1,50] [id:2,SELL,ACC1,SEC1,10] [id:3,BUY,ACC1,SEC1,12] [id:4,CANCEL,ACC1,SEC1,0] ||
<<<<<<<<<<<<<<<<<<<< REAL TIME POSITION >>>>>>>>>>>>>>>>>>>>>>

**********************GET SECURITIES INPUT********************
Please provide your input: 6,BUY,ACC1,SEC1,50

<<<<<<<<<<<<<<<<< REAL TIME POSITION >>>>>>>>>>>>>>>>>>>>>>>>>
 || ACC1 || SEC1 || 90 || [id:1,BUY,ACC1,SEC1,50] [id:2,SELL,ACC1,SEC1,10] [id:3,BUY,ACC1,SEC1,12] [id:4,CANCEL,ACC1,SEC1,0] [id:6,BUY,ACC1,SEC1,50] ||
<<<<<<<<<<<<<<<<<<<< REAL TIME POSITION >>>>>>>>>>>>>>>>>>>>>>


**********************GET SECURITIES INPUT********************
Please provide your input: 6,BUY,ACC2,SEC1,50|7,BUY,ACC2,SEC1,150|7,CANCEL,ACC2,SEC1,0|8,SELL,ACC2,SEC1,10

<<<<<<<<<<<<<<<<< REAL TIME POSITION >>>>>>>>>>>>>>>>>>>>>>>>>
 || ACC2 || SEC1 || 40 || [id:6,BUY,ACC2,SEC1,50] [id:7,BUY,ACC2,SEC1,150] [id:7,CANCEL,ACC2,SEC1,0] [id:8,SELL,ACC2,SEC1,10] ||
 || ACC1 || SEC1 || 90 || [id:1,BUY,ACC1,SEC1,50] [id:2,SELL,ACC1,SEC1,10] [id:3,BUY,ACC1,SEC1,12] [id:4,CANCEL,ACC1,SEC1,0] [id:6,BUY,ACC1,SEC1,50] ||
<<<<<<<<<<<<<<<<<<<< REAL TIME POSITION >>>>>>>>>>>>>>>>>>>>>>





RUN 2:

**************************************************************
*************Welcome to JP Morgan Trading Platform.***********
**************************************************************

**********************GET SECURITIES INPUT********************
Please provide your input: 1,BUY,ACC1,SEC1,50|2,SELL,ACC1,SEC1,10

<<<<<<<<<<<<<<<<< REAL TIME POSITION >>>>>>>>>>>>>>>>>>>>>>>>>
 || ACC1 || SEC1 || 40 || [id:1,BUY,ACC1,SEC1,50] [id:2,SELL,ACC1,SEC1,10] ||
<<<<<<<<<<<<<<<<<<<< REAL TIME POSITION >>>>>>>>>>>>>>>>>>>>>>

**********************GET SECURITIES INPUT********************
Please provide your input: 2,CANCEL,ACC1,SEC1,0

<<<<<<<<<<<<<<<<< REAL TIME POSITION >>>>>>>>>>>>>>>>>>>>>>>>>
 || ACC1 || SEC1 || 50 || [id:1,BUY,ACC1,SEC1,50] [id:2,SELL,ACC1,SEC1,10] [id:2,CANCEL,ACC1,SEC1,0] ||
<<<<<<<<<<<<<<<<<<<< REAL TIME POSITION >>>>>>>>>>>>>>>>>>>>>>

**********************GET SECURITIES INPUT********************
Please provide your input: 3,BUY,ACC2,SEC1,100|4,BUY,ACC2,SEC1,20|5,SELL,ACC2,SEC1,10|6,CANCEL,ACC2,SEC1,0

<<<<<<<<<<<<<<<<< REAL TIME POSITION >>>>>>>>>>>>>>>>>>>>>>>>>
 || ACC2 || SEC1 || 120 || [id:3,BUY,ACC2,SEC1,100] [id:4,BUY,ACC2,SEC1,20] [id:5,SELL,ACC2,SEC1,10] [id:6,CANCEL,ACC2,SEC1,0] ||
 || ACC1 || SEC1 || 50 || [id:1,BUY,ACC1,SEC1,50] [id:2,SELL,ACC1,SEC1,10] [id:2,CANCEL,ACC1,SEC1,0] ||
<<<<<<<<<<<<<<<<<<<< REAL TIME POSITION >>>>>>>>>>>>>>>>>>>>>>

**********************GET SECURITIES INPUT********************
Please provide your input: 7,BUY,ACC1,SEC1,50|8,SELL,ACC1,SEC1,15|9,CANCEL,ACC1,SEC1,0

<<<<<<<<<<<<<<<<< REAL TIME POSITION >>>>>>>>>>>>>>>>>>>>>>>>>
 || ACC2 || SEC1 || 120 || [id:3,BUY,ACC2,SEC1,100] [id:4,BUY,ACC2,SEC1,20] [id:5,SELL,ACC2,SEC1,10] [id:6,CANCEL,ACC2,SEC1,0] ||
 || ACC1 || SEC1 || 100 || [id:1,BUY,ACC1,SEC1,50] [id:2,SELL,ACC1,SEC1,10] [id:2,CANCEL,ACC1,SEC1,0] [id:7,BUY,ACC1,SEC1,50] [id:8,SELL,ACC1,SEC1,15] [id:9,CANCEL,ACC1,SEC1,0] ||
<<<<<<<<<<<<<<<<<<<< REAL TIME POSITION >>>>>>>>>>>>>>>>>>>>>>
