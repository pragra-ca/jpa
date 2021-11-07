pipeline {
  agent any
  tools {
  jdk 'jdk11'
  maven 'm3'
  }
  stages {
    stage('Compile') {
      steps {
        sh 'mvn compile'
      }
    }

  }
}
