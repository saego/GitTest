/**

 Program should create Order Books according to orders from XML file:

 https://yadi.sk/d/cciS7Dqy35uQjU

 Two actions supported: new order, delete exiting order. And after processing the whole file, print to standard output all order books generated.



 What is Order Book?

 Order Book is basically a combination of bid ladder and ask ladder. Bid ladder consists from buy orders; ask ladder consists from sell orders. See example order book and format of output for your program:



 Order book: ${order_book_name}

 BID                  ASK

 Volume@Price &ndash; Volume@Price

 10@100.1  &ndash; 11@100.2

 4@100.0    &ndash; 14@100.21

 98@99.98  &ndash; 14@100.23

 -----------      &ndash; 12@101.00



 Bid ladder is sorted from the highest bid price at the top to lowest price at the bottom.

 Ask ladder &ndash; visa versa, sorted from lowest at the top to highest price at the bottom.



 Note: when printing out resulted order books - quantity for all orders with the same price should be aggregated. In other words &ndash; on each side (bid / ask) of order book can have only one level with particular price.

 Note: You don&rsquo;t need to check XML file for correctness and implement any safety checks.

 Note: There are several different order books in XML file (see &lsquo;book&rsquo; attribute)



 Matching logic:

 When new bid/ask order is added into order book you should check opposite book side for matching. Checking always starts from the top of opposite side. To get execution (matching) price of counter orders must overlap (bid>=ask). For example:

 bid order at 4.4 matches ask order at 4.3
 ask order at 3.7 matches bid order at 3.8
 opposite side orders with same price matches as well.


 Matching is a process of execution two counter orders. When orders are matched they current volume is decreased by minimum current volumes of these orders:  volume_executed=min(ask_order,bid_order).  So when there is a match you need to adjust orders quantities. There could be three cases:

 Order existing in order book fully filled by incoming order &agrave; remove existing, adjust quantity of incoming order and add it
 Incoming order fully filled by existing order &agrave; adjust quantity of existing order
 Full quantity match &agrave; Remove existing order


 Also

 Describe do&rsquo;s and don&rsquo;ts of your solution, what could be done to speed it up further, improve, simplify?

 &#x444;&#x430;&#x439;&#x43b; &#x434;&#x430;&#x43d;&#x43d;&#x44b;&#x445; https://yadi.sk/d/cciS7Dqy35uQjU
 }
 */