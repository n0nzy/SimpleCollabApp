## SimpleCollabApp
This is a simple mobile app project to test collaboration with team members

For this collaboration, we are using the forking workflow, with a slight modification: the main branch we will be collaborating on is the **develop** branch, not the **master** branch.

If you are a **Windows** user, kindly enter the following command first.    
git config --global core.autocrlf true  
Linux and Mac users do not have to do this.

### Contribution Guide
Step 1: Kindly fork this repo.

Step 2: Clone (from your fork) to your local machine with the added option --branch, for example:
- git clone --branch develop https://github.com/(yourusername)/SimpleCollabApp.git

Note: If you clone without the *--branch* flag, it would still clone correctly, but git might give a warning that there's no master branch (I did not upload a Master branch).

Step 3: Add the my repo (the official repository) as a remote repo you can fetch from.
The Forking Workflow requires two remotes—one for the official repository, and one for your personal server-side repository.
We should stick with the industry standard convention for naming remotes, so we will use the following names:
 - origin as the remote for your forked repository (this will be created automatically when you run git clone) and

 - upstream for the official repository.

 Type the following:
  git remote add upstream https://github.com/n0nzy/SimpleCollabApp.git

 Using the command above, you’ll create the **upstream** remote. This will let you easily keep your local repository up-to-date as the official project progresses.

 Step 4: Create (feature) branch.  
 In the local repository you just cloned, create a branch corresponding to the feature you are working on, preferably prefix it with your name (eg. nonso-location-with-gps, or jeremy-sensor-gyro, or arjun-service-bounded etc).

 For example:
 git checkout -b nonso-location-with-gps

 **Note:** Prefixing helps to give me an idea **who-worked-on-what** at a glance, especially after integrating everyone's features to the main codebase.

 Step 5: Work on your feature.  
 In your feature branch, edit the code, stage and commit changes.

 For example  
 (After editing some code)  
 git commit -a -m "Add first draft of some feature"

 All of your changes will be entirely private until you push it to your public repository.
 And, if the official project has moved forward, you can access new commits with git pull

 Type the following:  
 git checkout (some-feature)  // Ensures you are in the some-feature branch  
 git pull upstream develop  // Fetch from official repo and merge into current branch

 Step 6: Publish your feature.  
 Once you are ready to integrate your feature, you need to do two things.
 1. First, you have to make your contribution accessible to other developers by pushing it to your public repository.
    - your origin remote should already be set up, so all you have to do is the following.  
 	   git push origin 'feature-branch' (where 'feature-branch' is the branch you want to upload to your repo on github).

 2. Second, you need to notify the project maintainer (i.e. me) that you want to merge your feature into the official codebase, by sending me a **Pull Request**.

 Typically, you’ll want to integrate your feature branch into the upstream remote’s develop branch.

 The project maintainer (i.e. me) integrates your features.
