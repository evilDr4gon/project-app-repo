pipeline {
    agent {
        label 'jenkinsv2-jenkins-agent'
    }

    triggers {
        githubPush() // Activa el pipeline cuando haya un push
    }

    stages {
        stage('Preparar Entorno') {
            steps {
                script {
                    // Configura el directorio como seguro para Git
                    sh 'git config --global --add safe.directory /home/jenkins/agent/workspace/temp'
                }
            }
        }

        stage('Construir Imagen Docker') {
            steps {
                container('dind') {
                    script {
                        // Obtén el short SHA del commit actual
                        def shortSha = sh(script: "git rev-parse --short HEAD", returnStdout: true).trim()
                        echo "Commit Short SHA: ${shortSha}"

                        // Construye la imagen Docker con el tag del SHA
                        sh """
                        echo "🐳 Construyendo imagen Docker con tag: ${shortSha}..."
                        docker build -t mi-quarkus-app:${shortSha} .
                        docker build -t mi-quarkus-app:latest .
                        """

                        echo "✅ Imagen Docker construida con tag: ${shortSha}"
                    }
                }
            }
        }
    }
}

