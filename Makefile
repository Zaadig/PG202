# Author: Elkarchi Jad
# works properly

UTEST = Position Jauge MonteeRepos MonteeFatigue MonteeSportif Autobus Arret GreffonAUn GreffonestUn GreffonTransportPleinestUn GreffonTransportPleinAUn
OPT_TEST = none
OPT_RUN = none
BUILD_DIR = .
MAN = .man.txt
RECETTE = SimpleSansCollecte SimpleCollecteEstUn SimpleCollecteAUn SimpleStarship SimpleCollecteDualStarshipAUn
JAVA_FILES = find ${BUILD_DIR} -name "*.java"
TST_FILES = find tst/ -name "*.java"
SRC_FILES = find src/ -name "*.java"
CLASS_FILES = find . -name "*.class"
JCFLAGS = -d build -cp build # -Xlint # Xlint for unsafe uses we want to check uncatched potential throws
JVFLAGS = -ea -cp build
PACK = tec
JC = javac.exe
JV = java.exe

.PHONY: clean 

build: build_repo
	 echo "compiling all java files in this repository ..."
	 ${JAVA_FILES} > files.txt
	 ${JC} ${JCFLAGS} @files.txt
	 rm -rf files.txt
	 echo "compilation complete"
	 echo "Done"

source: build_repo
	 echo "compiling all source files ..."
	 ${SRC_FILES} > files.txt
	 ${JC} ${JCFLAGS} @files.txt
	 rm -rf files.txt
	 echo "compilation complete"
	 echo "done"


build_repo:
	 echo "creating a build directory ..."
	 mkdir -p -m 600 build
	 echo "Done"


test: source
	 echo "compiling all test files ..."
	 ${TST_FILES} > files.txt
	 ${JC} ${JCFLAGS} @files.txt
	 rm -rf files.txt
	 echo "compilation complete"
	 echo "Done"


recette: source
	 echo ".... Running recipe test ...\n"
	 for exe in ${RECETTE} ; do \
		${JV} ${JVFLAGS} $$exe ${OPT_RUN}; \
	done
	 echo "\n Done"

utest: test
	 echo "Running tests ..."
	${JV} ${JVFLAGS} ${PACK}.LancerTests ${UTEST}; 
	 echo "Done"

man:
	 cat ${MAN}

clean: 
	 echo "Removing all class files and build directory ..."
	 ${CLASS_FILES} > files.txt
	 rm -rf files.txt build
	 echo "Done"

