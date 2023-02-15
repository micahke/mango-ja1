#!/bin/bash

if [[ $(uname) == "Darwin" ]]; then
  mvn package
  java -jar -XstartOnFirstThread target/mango-0.1.0.jar -Djava.library.path=target/natives-macos
else
  mvn package
  java -jar target/mango-0.1.0.jar -Djava.library.path=target/natives-linux
fi
