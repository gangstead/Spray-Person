# Spray-Person

Angular JS front end with REST api powered by Spray.  Typesafe Activator template created by Credera

## Front End Setup

Front end requires Bower, which requires npm

### Install NPM:
But this is an SBT app?!?  For the front end dependency management you will need npm.

Options
- https://www.npmjs.org/doc/README.html
- `brew install npm`

### Install bower
Bower is a front end dependency manager `npm install -g bower` (Linux users might have to run with sudo)

Download all the front end dependencies with `bower install`

*They will be in your `app\bower_components` directory as instructed by `.bowerrc`*

### Install Grunt CLI
Grunt is a front end task runner
`npm install -g grunt-cli`

Wire up the dependencies with `grunt bowerInstall`

*This modifies `app\index.html` to include your dependencies*



## Running Spray-Person
Start sbt with `sbt`

Start the container with `~container:start` (the ~ tells sbt to reload when any files change)

Navigate to the home page [http://localhost:8080/index.html](http://localhost:8080/index.html)
