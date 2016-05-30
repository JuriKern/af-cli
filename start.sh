#!/bin/bash

mvn compile
mvn exec:java -Dexec.mainClass="org.activefile.App" -Dexec.classpathScope="compile"
