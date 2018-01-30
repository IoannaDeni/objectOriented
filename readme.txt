@author Ioanna Deni
@version 12/10/2017

This is a file with:
	instructions - how to play the game
	newly implemented java class - images
	comments - on the design of the game
	future work to be done

Instructions:
The game has a single apllication even though it contains two versions of the game. I thought it might be better and easier for the user this way. 
The starting game has a start button that then gives a second frame when pressed to the two game options. 
The classic allows no user interaction with the program while the intelligent does allow the learning process to occur and saves it.
Both game logics have access to the same tree so once played the intelligent game and alter the tree the classic implements the alterations but when the game is exited the newly 
implementations are lost from memory. The button new Game allows you to restart at any point of the game even after altering it.
Also to play the executable you have to run it from the command line giving it the xml file in the folder it won't work with a double click cause it has no arguments.

Newly implemented java class:
Many people included me learn to manipulate and process images.
The images are loaded in the source directory so once download the file there should be no problem for java finding them.
I learnt a lot of cool stuff about it like that the image is not a different file but is read as a different file.

Comments:
The xml file contains a long tree with more than just 20 questions but every leaf is reached under 20 questions for both games.
The xml file is also writtem having a lot of attributes but the way the classes are written there was no problem reading it.
The program is arranged clearly in packages. The default packages contain the main applicaton the views and the game logic responsible for the restricted and unrestricted version.
The other packages are the datastructures package we used in assignment 7 the learner package responsible for extended the tree with only one class UpdateTree and the 
binaryTreeParsers package responsible for reading the xml file and building a binary tree based on it and the type of nodes.
The design of the game was mainly abstract based on assignment 7 and lab 10 so the design file on the finalProject directory is not representative of the design I followed but of the design
that I should have followed if I was very diligent on how I start my project but gliffy is an interesting app and makes the connections obvious so it is a  good start for next time.

Future work to be done:
I spent more than 7 hours trying to write the new tree on a new xml or trying to expand the tree on the current xml I succeeded in writing elements or nodes but I could not follow the way I wote the original
xml file thus writing a different xml would benefit noone since another parser must be designed so I gave uo but I learnt about type Node and Element and setTextNode and setAttribute("name", "value").
The work done on xml is not shown here.

Enjoy the GuessingGame!