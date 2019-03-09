Workflow 1 - working on the local master branch

1) Create new git repository in a directory where you have the existed project  or you will be creating the new project
$ git init
or get copy of existed git repository from the remote server into the local
$ git clone <remote git repository location>

working on the local master branch
2) add your existed project to the git repository  or create new project and add it to the git repository
$ git add <file1, file2 ...... dir1, dir2, .......>

3)commit the changes into the git repository   
$ git commit --all -m "project phase1 work."


4) merge the changes from local master branch to the remote branch(origin)
$ git merge origin master

project phase 1 changees are merged from the local master to the remote.


Workflow 2 - Using local branches
$ git init/clone

#create new local user branch
$ git branch -c my_branch1
$ git checkout my_branch1

# make the changes to fix the issue or implement the feature
# add changes to the stage area
$ git add *

# commit changes to the local branch
$ git commit -all -m "proejct phase1 completed."

#merge user branch to the local master
$ git checkout master
$ git merge my_branch1

# merge local master to the remote 
$ git fetch
$ git merge origin master 
