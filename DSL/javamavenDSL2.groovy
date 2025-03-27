job('Java Maven App DSL 2') {
    description('Java Maven App con DSL para el curso de Jenkins')
    scm {
        git('https://github.com/alealbaladejo/simple-java-maven-app.git', 'master') { node ->
            node / gitConfigName('alealbaladejo')
            node / gitConfigEmail('alealbaladejo29s@gmail.com')
        }
    }
    steps {
        maven {
          mavenInstallation('mavenjenkins')
          goals('-B -DskipTests clean package')
        }
        maven {
          mavenInstallation('mavenjenkins')
          goals('test')
        }
        shell('''
          echo "Entrega: Desplegando la aplicación" 
          java -jar "/var/jenkins_home/workspace/Java Maven App DSL 2/target/my-app-1.0-SNAPSHOT.jar"
        ''')  
    }
}
