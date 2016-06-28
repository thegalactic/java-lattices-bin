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
$ ./target/appassembler/bin/galactic-context
galactic-context [options...]
 -i (--input) INPUT                     : input from this file
 -p (--precedence) PRECEDENCE_GRAPH     : precedence graph (default:
                                          precedence-graph.dot)
 -n (--concept-lattice-next-closure)    : closed set lattice with next closure
 CLOSED_SET_LATTICE_NEXT_CLOSURE          (default: closed-set-lattice-next-clos
                                          ure.dot)
 -b (--closed-set-lattice-Bordat)       : closed set lattice of the context
 CLOSED_SET_LATTICE_BORDAT                with Bordat (default: closed-set-latti
                                          ce-Bordat.dot)
 -d (--dependence-graph)                : dependence graph (default:
 DEPENDENCE_GRAPH                         dependence-graph.dot)
 -g (--minimal-generators)              : minimal generators (default:
 MINIMAL_GENERATORS                       minimal-generators.txt)
 -r (--canonical-direct-basis)          : canonical direct basis (default:
 CANONICAL_DIRECT_BASIS                   canonical-direct-basis.txt)
 -c (--concept-lattice-Bordat)          : concept lattice of the context with
 CONCEPT_LATTICE_BORDAT                   Bordat (default: concept-lattice-Borda
                                          t.dot)
 -t (--table) TABLE                     : table of the concept lattice of the
                                          context (default: table.txt)
 -a (--context-reduced) REDUCED_CONTEXT : context reduced (default:
                                          reduced-context.txt)

  Example: galactic-context -i (--input) INPUT -p (--precedence) PRECEDENCE_GRAPH -n (--concept-lattice-next-closure) CLOSED_SET_LATTICE_NEXT_CLOSURE -b (--closed-set-lattice-Bordat) CLOSED_SET_LATTICE_BORDAT -d (--dependence-graph) DEPENDENCE_GRAPH -g (--minimal-generators) MINIMAL_GENERATORS -r (--canonical-direct-basis) CANONICAL_DIRECT_BASIS -c (--concept-lattice-Bordat) CONCEPT_LATTICE_BORDAT -t (--table) TABLE -a (--context-reduced) REDUCED_CONTEXT
~~~

You can use the dataset from http://www.upriss.org.uk/fca/examples.html. Special thanks to Uta Priss.

