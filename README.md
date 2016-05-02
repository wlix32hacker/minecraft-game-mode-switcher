# Introduction
This app is focused on visual edit for player attributes

# Using
* Download last release [click here](https://github.com/wlix32hacker/minecraft-game-mode-switcher/releases/download/0.0.1/minecraft-game-switcher.jar)
* Double click on it on windows to open or `java -jar minecraft-game-switcher.jar`
* Find your world folder and choose the `level.dat` as the picture below, **BEFORE on the game, save and quite to the title**

    ![](https://i.imgur.com/h2EbxmT.png)
* Choose your wanted mode 
* click on save
* load the game again
* enjoy !!!

You can switch between modes everywhere, **only** save and quite to the title first

**Obs:** save the game first then open/reopen the file on editor


# Current Features
## 0.0.1
* Can switch between modes

# Build from source
* [configure ant](https://ant.apache.org/manual/tutorial-HelloWorldWithAnt.html)
* compile the source

    ```bash
    $ git clone https://github.com/wlix32hacker/minecraft-game-mode-switcher.git
    $ cd minecraft-game-mode-switcher
    $ ant
    Buildfile: build.xml
    ...
    BUILD SUCCESSFUL
    Total time: 2 seconds
    
    $ cd dist/
    $ java -jar minecraft-game-switcher.jar
    ```

* you can copy the `dist/` folder content for where you want


# Contributing
Please help to develop issues or create a feature order

# License 
Apache 2
