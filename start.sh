#!/bin/bash

mvn compile
mvn exec:java \
  -Dexec.mainClass="org.activefile.App" \
  -Dexec.classpathScope="compile" \
  -Dexec.args="--file=/secret.doc --action=crypt CLIENT_ID CLIENT_KEY"
