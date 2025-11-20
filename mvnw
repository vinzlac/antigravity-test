#!/bin/sh
exec java "-Dmaven.multiModuleProjectDirectory=$(pwd)" -cp .mvn/wrapper/maven-wrapper.jar org.apache.maven.wrapper.MavenWrapperMain "$@"