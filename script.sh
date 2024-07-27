#!/bin/bash

for file in scenarios/*; do
  echo -e "\e[33mrunning program on ${file}:\e[0m"
  java -cp build simulator.Simulator ${file}
done
