# RPG Project

The goal of this project was to attempt to create a 2d RPG with an original story. 
&nbsp; I started the project in July 2015 as a way to improve my coding in Java and to learn the basics of Game Development.

Presently the game is in a very early stage of development with preliminary work having been completed on the following areas: 

- Basic movements
- Camera
- Collision detection 
- World rendering 
- SpriteSheets and animations
- NPCs

***Basic Movements***

&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; At the moment the protagonist is able to move in four directions, it is planned that the player will be able to move in eight directions in the finished game.  

*** Collision Detection ***

&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; The collision detection is handled via a box surrounding the player which is used to prevent wall-hacking and to ensure enemy encounters happen.

*** World Rendering ***

&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; The world is tiled-based with only the tiles displayed on the screen actually being rendered. The tiles all have a *canWalkOn* variable, which determines if the player is allowed to walk on them and thus be ignored by the collision detection box.

*** SpriteSheets ***

&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Every element of the game is extracted from a SpriteSheet. Animations are created this way too.

*** NPCs ***

&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; For now, the NPCs can only move randomly, and they use a XML file to store their dialogs. If the player is close enough, he can talk to them and they will stop moving as long


## How to play

&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; You just extract and run in it Eclipse as your project for now ! Later stage will involve a real launcher, promise !

## Controls

&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; For now, the key bindings go as follow : 

* *Z* is for up
* *S* is for down
* *Q* is for left
* *D* is for right
* *Enter* is to speak with NPCs
* *I* should soon display the inventory

# Yet to be done
- ### Inventory
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; This is the next step and should be what I'm focusing on right now. Not much to say, it's an inventory.

- ### NPCs Interactions

&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; As this game is thought to be a RPG, NPCs interactions should appear somewhat in the game. For now, NPCs can display simple lines of dialog, but plans are made to make them react to the player's actions. Multiple answers to a question are not a priority, as it is not one of my favorite focus of modern RPGs, but could be added later on if needs be.

- ### Combat
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Combat hasn't been very much discussed, and that's because nothing has truly been done for now to implement it. As I see it, combat will not happen randomly. Think *Persona 4* instead of *Dragon Quest 8* if you want. I feel like there could be something a bit strategic added there to make the player willing to start his fight in the best conditions. But combat is certain not to be uploaded for a long time, as I've not even determined if it will be turn-based or not.

- ### World Rendering

&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; I'll be honest, I'm more into hand-crafted worlds than randomly generated ones. This time, think *Magical Starsign* instead of *Persona 4* or *Oreshika*. So, for now, I do intend to create each map manually. 


## Resources used

I took a lot of art from [OpenGameArt](http://opengameart.org/) in order to try the code written, so all credit goes there.

