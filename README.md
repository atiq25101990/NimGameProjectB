# NimGameProjectB
This project is a second iteration (Project B) of a existing nim game project in unimelb:

In this project, we introduce a third class NimGame. The game playing process is delegated from Nimsys
to NimGame. Since only one game will be active at any given time, only a single NimGame instance is
required by Nimsys. Nimsys should also maintain a collection of players. Initially, this collection will be
empty - players will need to be added in order to play a game.

A NimGame instance needs to have the following information associated with it:
* A current stone count
* An upper bound on stone removal
* Two players

The system should allow for games of Nim to be played, with the rules of the game, and the players,
specified by the user.
A player, as described by the NimPlayer class, needs to have the following information associated with
it:
* A username
* A given name
* A family name
* Number of games played
* Number of games won

The system should allow players to be added. It should also allow for players to be deleted, or for their
details to be edited. Players should not be able to directly edit their game statistics, although they
should be able to reset them.
The system is a text based interactive program that reads and executes commands from standard input
(the keyboard) until an 'exit' command is issued, which will terminate the program. If a command
produces output, it should be printed to standard output (the terminal).
