### **The 14 habits of highly effective developers **

#### Introduction

Many believe that transitioning from an effective Junior-level developer to a mid-level is just a matter of time and experience. Truth is that the line separating these 2 kinds of developers is very thin and subject. This article is not going to add more to the endless debate on "What exactly defines a mid-level developer".

To be honest, I firmly believe that something that can shift one's mindset and help in transitioning on from a Junior to a Mid-level or Senior developer is **habits**:

***A habit is something that you start doing systematically until it is no longer something strange to you but comes naturally.***

***Forming code-related and work-related habits is of crucial importance when it comes to professional and personal advancement.***

Let's see a list of everyday habits that, upon mastering them, will definitely help you get to the next level and progress fruitfully:

#### 1.Write small methods

Ideally, no more 20~30 lines of code (LoC)long. This habit is extremely important. It will not only force you to write compact code,but it will help you analytical thinking when it comes to modularize your code. Having big methods with a high degree of indentation (many ifs, for loops etc) is a nightmare. It may seem easy and straightforward when you write a method like that , but after some days even you will have a hard time figuring out when this method even does.

***To add insult to injury, big methods often are not-reusable . They were written to service only on need in project and it will be difficult to be used anywhere else.***

#### 2.Give meaningful names

Both to methods and variables . It is not acceptable for a mid-level developer to have variables named "X" or "xyz" , or even "object" . The purpose of naming variables with English words is so that they have a meaning.

***Communicating with your code is far more important than communicating with documentation and comments.***

***The purpose of comments is to explain the "why" , not the "how" in the code.***

Having meaningful variables helps you communicate with whoever reads the code better , and may remove the need for an excessive amount of comments .  The same goes both for **variables** and **methods** . Also , when struggling with naming a method for too long , consider refactoring your code so that the method gets more simple . A name for a good , clean method always comes to mind easier than the name of a cluttered one.

***When struggling with naming things , take a step back and think of the possibility that the component you are trying to name is too complicated and needs refactoring.***

#### 3.Don't clutter your methods with many parameters

Having many parameters in a method is a sign for refactoring . More often than not , writing this kind of methods violates the SPR(Single Responsibility Principle) meaning that they do too many things . An efficient , clean method does one thing , **well** . As Uncle Bob said , three is the maximum arguments acceptable . Although this may not strict . It gives you an overview of the desired number of arguments in a method . 

***Fight the urge to change some of your method's local parameters into class fields . Consider refactoring your code so that a method does fewer things , or break up your method into 2 separate ones .*** 

Quote by Robert  C. Martin: "*Functions should have a small number of  arguments . No arguments is best , followed by one , two , and three . More than three is very questionable and should be avoided with prejudice* . "

 