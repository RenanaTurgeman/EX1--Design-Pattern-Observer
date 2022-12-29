
# Deisgn Patern: Observer 

This code implements the deisgn patern observer.
In this exercise we use  the UndoableStringBuilder which we implements in Ex0.

In this exercise we got two interfaces, Member and Sender, while the Member interface is the observer interface and the Sender is the observerable interface.

It is contains the following classes:
## 1) GroupAdmin: 
This class implements the Sender interface that represent the observerable. It contains the GroupAdmin actions (undoablestringbuilder) and list of members that supposed to get update about the changes that done in the GroupAdmin.
every GroupAdmin have undoablestringbuilder field and ArrayList field that hold all the register members.
In this class we have the method notifyObservers, when member registered to the GroupAdmin, we add the member to the ArrayList, and when change is maid in the undoablestringbuilder, the GroupAdmin notify all the members about this change.

## 2) ConcreteMember:
This class implements the interface Member that represent the observers and holds undoablestringbuilder field. Each ConcreteMember contains shallow copy of the undoablestringbuilder of the GroupAdmin.
So when ConcreteMember registered to a GroupAdmin, he get update from the GroupAdmin and change his own undoablestringbuilder field.
 
# TESTS
## 1) GroupAdminTest:
In this class we test the GroupAdmin class, we check how the function can handle with edge cases like register member that already exsits and so on.
## 2) ConcreteMemberTest:
In this class we test the ConcreteMember class, we test the function update.
## 3)  JvmUtilities:
In this class we test how much memory the objects take.


## Authors

- [@RenanaTurgeman](https://github.com/RenanaTurgeman/EX1--StringBuilder)
- [@OfirShitrit](https://github.com/RenanaTurgeman/EX1--StringBuilder)
