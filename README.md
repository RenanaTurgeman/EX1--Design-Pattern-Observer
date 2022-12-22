# Deisgn Patern: Observer 
# EX1--StringBuilder

This code implements the deisgn patern observer.
It is contains the following classes:
1) GroupAdmin: 
This class implements the interface Sender that represent the observerable. It contains the GroupAdmin actions (undoablestringbuilder) and list of members that supposed to get update about the changes that done in the GroupAdmin.

2) ConcreteMember:
This class implements the interface Member that represent the observers. It contains shallow copy of the undoablestringbuilder of the GroupAdmin.
 

## Authors

- [@RenanaTurgeman](https://github.com/RenanaTurgeman/EX1--StringBuilder)
- [@OfirShitrit](https://github.com/RenanaTurgeman/EX1--StringBuilder)
