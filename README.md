java-lattices-bin
=================

[![Issues](https://img.shields.io/github/issues-raw/thegalactic/java-lattices-bin.svg)](https://github.com/thegalactic/java-lattices-bin/issues)
[![Snapshot](http://img.shields.io/badge/snapshot-v2.0.0-orange.svg)](https://github.com/thegalactic/java-lattices-bin)
[![License](http://img.shields.io/badge/license-CeCILL--B-blue.svg)](http://www.cecill.info/licences/Licence_CeCILL-B_V1-en.html)

This package contains command line applications using the [java-lattices library](https://github.com/thegalactic/java-lattices).

Installation
------------

~~~
$ git clone https://github.com/thegalactic/java-lattices-bin.git
$ cd java-lattices-bin
$ mvn package
~~~

Usage
-----

~~~
$ ./target/appassembler/bin/galactic-context [options...]
 -i (--input)                           : input from this file

 -p (--precedence)                      : precedence graph
                                          default: precedence-graph.dot
 -n (--concept-lattice-next-closure)    : closed set lattice with next closure
                                          default: closed-set-lattice-next-closure.dot
 -b (--closed-set-lattice-Bordat)       : closed set lattice of the context with Bordat
                                          default: closed-set-lattice-Bordat.dot
 -d (--dependence-graph)                : dependence graph
                                          default: dependence-graph.dot
 -g (--minimal-generators)              : minimal generators
                                          default: minimal-generators.txt
 -r (--canonical-direct-basis)          : canonical direct basis
                                          default: canonical-direct-basis.txt
 -c (--concept-lattice-Bordat)          : concept lattice of the context with Bordat
                                          default: concept-lattice-Bordat.dot
 -t (--table) TABLE                     : table of the concept lattice of the context
                                          default: table.txt
 -a (--context-reduced) REDUCED_CONTEXT : context reduced
                                          default: reduced-context.txt
~~~

You can use the dataset from http://www.upriss.org.uk/fca/examples.html. Special thanks to Uta Priss.

