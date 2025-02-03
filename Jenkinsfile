// Primer pipeline
pipeline {
    agent {
        label 'jenkinsv2-jenkins-agent'
    }

    triggers {
        githubPush() // Activa el pipeline cuando haya un push
    }

    stages {
        stage('Construir y Subir Imagen Docker') {
            steps {
                container('dind') {
                    script {
                        // Configura el directorio como seguro dentro del contenedor
                        sh '''
                        git config --global --add safe.directory /home/jenkins/agent/workspace/temp
                        '''

                        // Obtén el short SHA del commit actual
                        def shortSha = sh(script: "git rev-parse --short HEAD", returnStdout: true).trim()
                        echo "Commit Short SHA: ${shortSha}"

                        // Define variables para el nombre de la imagen y el registro
                        def imageName = "d4rkghost47/mi-quarkus-app"

                        // Construye la imagen Docker con las etiquetas
                        sh """
                        echo "🐳 Construyendo imagen Docker con tag: ${shortSha}..."
                        docker build -t ${imageName}:${shortSha} .
                        docker build -t ${imageName}:latest .
                        """

                        // Loguearse al registro
                        sh """
                        echo "dckr_pat_zwGUehrkDTtA3bg0V5os4pOj-qQ" | docker login -u "d4rkghost47" --password-stdin
                        """

                        // Subir la imagen al registro
                        sh """
                        echo "📤 Subiendo imagen Docker al registro..."
                        docker push ${imageName}:${shortSha}
                        docker push ${imageName}:latest
                        """

                        echo "✅ Imagen Docker subida al registro con éxito"
                    }
                }
            }
        }
    }
}

