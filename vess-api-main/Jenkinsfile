pipeline {
    agent any

    environment {
        SPRING_PROFILES_ACTIVE="prod"
        POSTGRESQL_CRED = credentials('postgres-id')
        DB_JDBC_USER = "${POSTGRESQL_CRED_USR}"
        DB_JDBC_PASSWORD = "${POSTGRESQL_CRED_PSW}"
        SERVER_PORT=8650
        DATABASE_URL="jdbc:postgresql://postgresql:5432/vess"
        DATABASE_USERNAME="${POSTGRESQL_CRED_USR}"
        DATABASE_PASSWORD="${POSTGRESQL_CRED_PSW}"

        MINIO_CRED = credentials('minio-id')
        MINIO_ENDPOINT="https://minio.app.pb.utfpr.edu.br"
        MINIO_PORT=443
        MINIO_ACCESS_KEY="${MINIO_CRED_USR}"
        MINIO_SECRET_KEY="${MINIO_CRED_PSW}"
        MINIO_SECURE=true
        MINIO_BUCKET_NAME="vess"
    }

    stages {   
        stage('Docker Compose UP') {
            steps {
                sh 'docker compose up -d --build'
            }
        }
    }
}
