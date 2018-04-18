import yaml
import argparse

def createParser ():
    parser = argparse.ArgumentParser()
    parser.add_argument ('name', nargs='?')

    return parser


parser = createParser()
namespace = parser.parse_args()

if namespace.name != None and namespace.name !='':
    with open(namespace.name, 'r', encoding="utf-8") as stream:
        try:
            conf = yaml.load(stream)
            
            for group in conf.keys():
                if group == 'version':
                    print(conf[group])
                else:
                    print()
                    print('#'+conf[group]['name'])
                    for distr in conf[group]['distributions']:
                        print(distr['url'], distr['path'],sep='@')
        except yaml.YAMLError as exc:
            print(exc)
else:
    print("Usage: generate-artifacts.py <file with cradle config>.yml")