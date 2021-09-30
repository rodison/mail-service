#!/bin/bash

export JAVA_HOME=/home/jexperts/jdk-11.0.12

java -cp "jooq-3.15.3.jar:jooq-meta-3.15.3.jar:jooq-codegen-3.15.3.jar:reactive-streams-1.0.3.jar:r2dbc-spi-0.9.0.M1.jar:jaxb-api-2.3.1.jar:postgresql-42.2.23.jar" org.jooq.codegen.GenerationTool ./jooq-gen-config.xml
