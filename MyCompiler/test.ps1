set-psdebug -trace 0
function assert($one, $two){
	$expected = $one
	$input = $two

	./9cc $input tmp.s
	gcc tmp.s -o tmp 
	./tmp
	$actual = $LASTEXITCODE

	if($actual -eq $expected){
		echo "$input => $actual"
	} else {
		echo "$input => $expected expected, but got $actual"
	}
}

assert 0 0
assert 42 42
assert 21 "5+20-4"
assert 41 " 12 +  34 -5"
assert 47 "5+6*7"
assert 15 "5*(9-6)"
assert 4 "(3+5)/2"

echo OK
