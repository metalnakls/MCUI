#!/usr/bin/env python3
"""Check Fabric's mixin-package isolation rule without launching Minecraft."""
import json,sys,zipfile
with zipfile.ZipFile(sys.argv[1]) as jar:
 config=json.loads(jar.read('cleanmenu.mixins.json'))
 prefix=config['package'].replace('.','/')+'/'
 mixins={prefix+n for n in config['client']}
 offenders=[n for n in jar.namelist() if n.startswith(prefix) and n.endswith('.class') and n[:-6].split('$')[0] not in mixins]
 assert not offenders, 'runtime classes in reserved mixin package: '+str(offenders)
 assert 'cleanmenu/MenuConfig.class' in jar.namelist()
 print('PASS runtime settings class is outside the reserved mixin package')
