# Clojure Kubernetes Demo

This project demonstrates how to deploy a simple Clojure web application using Kubernetes. It serves as a learning tool for understanding the basics of containerization and orchestration with Docker and Kubernetes.

## Prerequisites

- Docker Desktop with Kubernetes enabled (enable in Docker Desktop settings)
  ```
  brew install --cask docker
  ```
- Clojure and Leiningen
  ```
  brew install clojure
  brew install leiningen
  ```
- kubectl command-line tool
  ```
  brew install kubectl
  ```

## Project Structure

- `src/clojure_k8s_demo/core.clj`: Main application code
- `project.clj`: Leiningen project file
- `Dockerfile`: Instructions for building the Docker image
- `deployment.yaml`: Kubernetes Deployment configuration
- `service.yaml`: Kubernetes Service configuration

## Getting Started

1. Clone the repository
2. Build the Docker image:
   ```
   docker build -t clojure-k8s-demo:v1 .
   ```

3. Apply the Kubernetes configurations:
   ```
   kubectl apply -f deployment.yaml
   kubectl apply -f service.yaml
   ```
  
4. Verify the deployment:
   ```
   kubectl get pods
   kubectl get services
   ```
  
5. Test the application:
   ```
   curl localhost
   ```

## Scaling the Application

To scale the application, use:
```
kubectl scale deployment clojure-k8s-demo --replicas=5
```

## Updating the Application

1. Make changes to the Clojure code
2. Rebuild the Docker image with a new tag:
   ```
   docker build -t clojure-k8s-demo:v2 .
   ```
  
3. Update the `deployment.yaml` file with the new image tag:
   ```
   ...
   spec:
     ...
     template:
       ...
       spec:
         containers:
           ...
           image: clojure-k8s-demo:v2
   ```

4. Apply the changes:
   ```
   kubectl apply -f deployment.yaml
   ```
   
- You can also check the images created:
  ```
  docker images | grep clojure-k8s-demo
  ```

## Troubleshooting

If pods are not starting, check the logs:
```
kubectl logs <pod-name>
```

For more detailed information about a pod:
```
kubectl describe pod <pod-name>
```

## Learning Objectives

This project covers:
- Building a simple Clojure web application
- Containerizing the application with Docker
- Deploying the application to Kubernetes
- Basic Kubernetes concepts: Pods, Deployments, Services
- Scaling and updating applications in Kubernetes
